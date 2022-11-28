function queren()
{
    var se=confirm("请确认是否需要手动备份表格,导入时会自动备份一份数据,请不要随便按造成数据冗余");
    if (se==true)
    {
        alert("开始备份");
        //
        $.ajax({
            type: "post",
            url: "/PublicTool/backupsTool",
            contentType: "application/json; charset= utf-8",
            data: '{"name":"小黑", "age":20, "hobby":"basketball"}',
            dataType: "json",
            success:function(data){
                alert(data);
            }
        });
        //

    }
    else
    {
        alert("已取消");
    }
}
function clearTable(){
    // var yearNumb = document.getElementById("#yearNumb").v;
    var yearNumb = $('#yearNumb').val();
    if(yearNumb==null||yearNumb==undefined||yearNumb==""){
        alert("请输入你需要的清空的年份")
    }else {
        var se=confirm("请确认是否需要清理关于"+yearNumb+"表格数据");
        if (se==true)
        {
            alert("开始清理");
            //
            data1 = {
                "yearNumb":yearNumb
            }
            $.ajax({
                type: "post",
                url: "/PublicTool/clearTableByYear",
                contentType: "application/json; charset= utf-8",
                data: JSON.stringify(data1),
                dataType: "json",
                success:function(data){
                    alert(data);
                }
            });
        }
        else
        {
            alert("已取消");
        }
    }

}