$(document).ready(function(){
    $('.command_edit').click(function(){
        var parent = $(this).parents('tr');
        var TDs = parent.find('td');
        var form = $("form[action='add']");
        if(form.size() == 0)
            form = $("form[action='update']");
        
        $('.form_table #identity').val($(TDs[1]).text());
        var id = $(TDs[2]).text();
        var exp = '.form_table #aerial\\.id [value="'+id+'"]';
        $(exp).attr("selected", "selected");
        
        id = $(TDs[3]).text();
        exp = '.form_table #cable\\.id [value="'+id+'"]';
        $(exp).attr("selected", "selected");
        
        id = $(TDs[4]).text();
        exp = '.form_table #radiostation\\.id [value="'+id+'"]';
        $(exp).attr("selected", "selected");
        
        $('.form_table #cableLength').val($(TDs[5]).text());
        $('.form_table #aerialHeight').val($(TDs[6]).text());
    });
});


