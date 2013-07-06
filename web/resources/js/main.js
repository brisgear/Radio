$(document).ready(function(){
    $('.command_edit').click(function(){
        $('.command_edit').parents('tr').removeClass('selected');
        $('.command_edit').removeClass('submit').val('Изменить');
        var parent = $(this).parents('tr');
        //parent = $(this).parent('tr');
        //var tds = parent.find('td');
        var TDs = parent.find('td');
        var size = TDs.size();
        var form = $("form[action='add']");
        var inputs = form.find('input');
//        console.log(parent.html());
//        console.log(form);
//        console.log(inputs);
//        console.log(TDs);
        var entity = form.attr("id");
        form.attr("action", "update").append('<input type="hidden" id="id" name="id" value="'+$(TDs[0]).text() +'"/>');
        form.append('<input type="hidden" name="_method" value="PUT"/>');
        form.find("input[type='submit']").removeClass('submit').addClass('command_edit').val("Изменить");
        $(this).click(function(){window.location.reload()});
        $(this).addClass('submit').val('Отмена');
        parent.addClass('selected');
        console.log($('#form_table'));
        
    });

});
//function processInputs(inputs,TDs){
//    inputs.forEach(function (item,index){
//        if($(item).attr("type") == "text"){
//            
//        }
//    });
//}
