$(document).ready(function(){
    $('.command_edit').click(function(){
        
        var parent = $(this).parents('tr');
        var TDs = parent.find('td');
        var form = $("form[action='add']");
        if(form.size() == 0)
            form = $("form[action='update']");
        
        $('.form_table #name').val($(TDs[1]).text());
        var index = $(TDs[2]).text();
        var a = $(".form_table input[type='radio']").get(index);
        $(a).attr("checked", "checked");
        $('.form_table #fade').val($(TDs[2]).text());
        
        $('.form_table #amp').val($(TDs[2]).text());
    });
});


