/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function renderPager(container,pageindex,totalpage,gap)
{
    var div_container = document.getElementById(container);
    var content = "";
    if(pageindex - gap > 1)
        content += "<a href=\"list?page=1\">First</a>";
    for(var i=pageindex-gap;i<pageindex;i++)
        if(i > 0)
            content += "<a href=\"list?page="+i+"\">"+i+"</a>";
    
    content += "<span>" + pageindex + "</span>";
    
    for(var i=pageindex+1;i<pageindex + gap;i++)
        if(i <= totalpage)
            content += "<a href=\"list?page="+i+"\">"+i+"</a>";
    
    if(pageindex + gap < totalpage)
        content += "<a href=\"list?page="+totalpage+"\">Last</a>";
    
    div_container.innerHTML = content;
    
}

