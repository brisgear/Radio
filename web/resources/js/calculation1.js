$(document).ready(function(){
    globalInit();
    initSelectListener();
    liveBindInit();
    addCalculateListener();
});
function addCalculateListener(){
    $('#calculate').click(function(){
        var ajaxDiv = $('#ajax_loader');
        ajaxDiv.removeClass("hidden");
        var problem = {
            "radiostationType.type1":$('#radiostationType\\.type1').val(),
            "quality":$('#quality').val(),
            "trackType":$('#trackType').val(),
            "config1.id":$('#config1\\.id').val(),
            "config2.id":$('#config2\\.id').val(),
            "config1.cableLength":$('#config1\\.cableLength').val(),
            "config2.cableLength":$('#config2\\.cableLength').val(),
            "config1.aerialHeight":$('#config1\\.aerialHeight').val(),
            "config2.aerialHeight":$('#config2\\.aerialHeight').val(),
            "config1.radiostation.id":$('#config1\\.radiostation\\.id').val(),
            "config1.cable.id":$('#config1\\.cable\\.id').val(),
            "config1.aerial.id":$('#config1\\.aerial\\.id').val()
        }
        $.ajax({
            type:'GET',
            url:CONTEXT_PATH+"calculation/go",
            data:problem,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success:function(result){
                $('#ajax_loader').addClass("hidden");
                $('#result1').text(result.r1.toPrecision(3));
                $('#result2').text(result.r2.toPrecision(3));
            },
            error:function(){
                $('#ajax_loader').addClass("hidden");
                $('#result1').text("Ошибка");
                $('#result2').text("Ошибка");
            }
        });
    });
}

function initSelectListener(from,to){
    $('#radiostationType\\.type1').change(function(){
        var raw = $(this).find(':selected').text();
        var fromAndTo = raw.split(' - ');
        var from = fromAndTo[0];
        var to = fromAndTo[1];
        $('.from').text(from);
        $('.to').text(to);
      
        getRadiostationConfigByTypeRadiostation(from,to);
        $(this).find("[value='-1']").detach();
    });
}

function globalInit(){
    CURRENT_PAGE="calculation/first";
    GET_MAP_URL = "calculation/getTypeByName";
    CONFIG1_ID = '#config1\\.id';
    CONFIG2_ID = '#config2\\.id';
    AERIAL1_ID = '#config1\\.aerial\\.id';
    AERIAL2_ID = '#config2\\.aerial\\.id';
    CABLE1_ID = '#config1\\.cable\\.id';
    CABLE2_ID = '#config2\\.cable\\.id';
    RADIOSTATION1_ID = '#config1\\.radiostation\\.id';
    RADIOSTATION2_ID = '#config2\\.radiostation\\.id';
    POWER1 ='#config1\\.radiostation\\.power';
    POWER2 ='#config2\\.radiostation\\.power';
    FADE1 ='#config1\\.cable\\.fade';
    FADE2 ='#config2\\.cable\\.fade';
    AMP1 ='#config1\\.aerial\\.amp';
    AMP2 ='#config2\\.aerial\\.amp';
    HEIGHT1 ='#config1\\.aerialHeight';
    HEIGHT2 ='#config2\\.aerialHeight';
    LENGTH1 ='#config1\\.cableLength';
    LENGTH2 ='#config2\\.cableLength';
    
    config1 = new Object();
    config1 = new Object();
    //    RS='РС'
    //    RV='РВ'
    //    RN='РН'
    var url = document.URL;
    CONTEXT_PATH = url.substring(0, url.indexOf(CURRENT_PAGE, 0));
}

function getRadiostationConfigByTypeRadiostation(from, to){
    $.getJSON(CONTEXT_PATH+GET_MAP_URL+'/'+from, function(map) {
        fillSelect(map,CONFIG1_ID);
        config1=map;
        console.log(config1);
        
    });
    $.getJSON(CONTEXT_PATH+GET_MAP_URL+'/'+to, function(map) {
        fillSelect(map,CONFIG2_ID)
        config2=map;
        console.log(config2);
    });
}

function fillSelect(map,exr){
    //$.each(map, alert(this.id));
    var tmp = '<option value="-1"> - </option>';
    map.forEach(function (i){
        tmp += '<option value="'+i.id+'">'+i.identity+'</option>';
    });
    $(exr).html(tmp);
}

function liveBindInit(){
    $(CONFIG1_ID).live("change", function(){
        var id = $(this).val();
        var index = findById(parseInt(id,10),config1);
        console.log(config1[index]);
        $(POWER1).val(config1[index].radiostation.power);
        $(FADE1).val(config1[index].cable.fade);
        $(AMP1).val(config1[index].aerial.amp);
        $(AERIAL1_ID).val(config1[index].aerial.id);
        $(CABLE1_ID).val(config1[index].cable.id);
        $(RADIOSTATION1_ID).val(config1[index].radiostation.id);
        $(LENGTH1).val(config1[index].cableLength);
        $(HEIGHT1).val(config1[index].aerialHeight);
    });
    $(CONFIG2_ID).live("change", function(){
        var id = $(this).val();
        var index = findById(parseInt(id,10),config2);
        console.log(config2[index]);
        $(POWER2).val(config2[index].radiostation.power);
        $(FADE2).val(config2[index].cable.fade);
        $(AMP2).val(config2[index].aerial.amp);
        $(AERIAL2_ID).val(config2[index].aerial.id);
        $(CABLE2_ID).val(config2[index].cable.id);
        $(RADIOSTATION2_ID).val(config2[index].radiostation.id);
        $(LENGTH2).val(config2[index].cableLength);
        $(HEIGHT2).val(config2[index].aerialHeight);
    });
}

function findById(id,map){
    var res ;
    map.forEach(function (element, index){
        if(element.id==id)
            res=index;
        console.log(index);
    });
    return res;
}