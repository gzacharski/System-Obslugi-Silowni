function setCurrentDate(){
    var selectedDateTime=document.getElementById("selectedDateTime");
    var today;
    today=new Date();
    
    selectedDateTime.value=today.toISOString().substring(0,16);
}

function setPreviousDate(){
    var previousDateTime = document.getElementById("previousDateTime");
    //var previousWeek=new Date();
    var previousWeek=document.getElementById("selectedDateTime").value;

    var buffer1 = previousWeek.getDate() - 7;
    previousWeek.setDate(buffer1);
    previousDateTime.value = previousWeek.toISOString().substring(0, 16);
}

function setNextDate(){
    var nextDateTime = document.getElementById("nextDateTime");
    //var nextWeek=new Date();
    var nextWeek=document.getElementById("selectedDateTime").value;

    var buffer2 = nextWeek.getDate() + 7;
    nextWeek.setDate(buffer2);
    nextDateTime.value = nextWeek.toISOString().substring(0, 16);
}

function setDates(){
    setCurrentDate();
}