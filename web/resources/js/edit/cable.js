$(document).ready(function(){
    $('.command_edit').click(function(){
        
        var parent = $(this).parents('tr');
        var TDs = parent.find('td');
        var form = $("form[action='add']");
        if(form.size() == 0)
            form = $("form[action='update']");
        $('.form_table #name').val($(TDs[1]).text());
        $('.form_table #fade').val($(TDs[2]).text());
    });
});


