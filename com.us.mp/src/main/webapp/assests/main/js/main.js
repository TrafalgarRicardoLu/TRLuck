$(function () {
    $(document).ready(function () {
        $("#addForm").validate({
            rules: {
                pname: {
                    required: true
                },
                password: {
                    required: true
                },
                sex: {
                    required: true
                }

            },
            messages: {
                pname: {
                    required: "Can't be empty"
                },
                password: {
                    required: "Can't be empty"
                },
                sex: {
                    required: "Can't be empty"
                }
            }
        });
    });
});

function getDays() {
    $(document).ready(function () {
        $("#day").empty();
        var year = $("#year").val();
        var month = $("#month").val();
        var Month = {'Jan':31,'Feb':28,'Mar':31,'Apr':30,'May':31,'Jun':30,'Jul':31,'Aug':31,'Sep':30,'Oct':31,'Nov':30,'Dec':31};
        if(month in Month){
           var days = Month[month];
           var isLeapYear = (year%100==0&&year%400==0)||(year%100!=0&&year%4==0)?true:false;
           if(isLeapYear)
               days++;
           for(var i=1;i<=days;i++){
               $("#day").append('<option>'+i+'</option>');
           }
        }else{
            alert('false')
        }
    })
}

