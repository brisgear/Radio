$(document).ready(function(){
    $('.command_edit').click(function(){
        
        var parent = $(this).parents('tr');
        var TDs = parent.find('td');
        var form = $("form[action='add']");
        if(form.size() == 0)
            form = $("form[action='update']");
        
        $('.form_table #name').val($(TDs[1]).text());
        $('.form_table #power').val($(TDs[2]).text());
        var index = $(TDs[3]).text();
        var a = $(".form_table input[type='radio']").get(index);
        $(a).attr("checked", "checked");
        $('.form_table #cutoff').val($(TDs[4]).text());
        $('.form_table #frequencyRange').val($(TDs[5]).text());
        $('.form_table #sensitivity').val($(TDs[6]).text());
        $('.form_table #selectivity2').val($(TDs[7]).text());
        $('.form_table #selectivity3').val($(TDs[8]).text());
    });
});


