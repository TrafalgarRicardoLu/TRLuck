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


$(function(){
 $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
})

function getDays() {
    $(document).ready(function () {
        $("#day").empty();
        var year = $("#year").val();
        var month = $("#month").val();
        var Month = {
            'Jan': 31,
            'Feb': 28,
            'Mar': 31,
            'Apr': 30,
            'May': 31,
            'Jun': 30,
            'Jul': 31,
            'Aug': 31,
            'Sep': 30,
            'Oct': 31,
            'Nov': 30,
            'Dec': 31
        };
        if (month in Month) {
            var days = Month[month];
            var isLeapYear = (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0) ? true : false;
            if (isLeapYear)
                days++;
            for (var i = 1; i <= days; i++) {
                $("#day").append('<option>' + i + '</option>');
            }
        } else {
            alert('false')
        }
    })
}

function deleteConfirm() {
    var c = confirm("Are you sure to delete the person?");
    if (c == true) {
        return true;
    } else {
        return false;
    }
}

$(function () {
    $(function () {
        $('#PersonTable').bootstrapTable({
            url: "http://localhost:8080/rest/person/",
            pagination: true,
            pageNumber: 1,
            pageSize: 10,
            showRefresh: true,
            search: true,
            clickToSelect: true,
            editable: true,
            queryParams: function (param) {
                return {};
            },
            idField: "pid",
            columns: [{
                checkbox: true
            }, {
                field: "pid",
                title: "ID",
                align: 'center'
            }, {
                field: "pname",
                title: "Name",
                align: 'center',
                editable: {
                    type: 'text',
                    title: 'Name',
                    validate: function (v) {
                        if (!v) return 'Can not be null';
                    }
                }
            }, {
                field: "sex",
                title: "Sex",
                align: 'center'
            }, {
                field: "birth",
                title: "Birthday",
                align: 'center',
                editable: {
                    type: 'text',
                    title: 'Birthday',
                    validate: function (v) {
                        if (!v) return 'Can not be null';
                    }
                }
            }, {
                field: "department",
                title: "Depart",
                align: 'center',
                editable: {
                    type: 'text',
                    title: 'Depart',
                    validate: function (v) {
                        if (!v) return 'Can not be null';
                    }
                }
            }, {
                title: "Operations",
                events: operateEvents,
                formatter: operateFormatter
            }],
            onEditableSave: function (field, row, oldValue, $el) {
                var pid = [row.pid];
                var url = "http://localhost:8080/rest/person/" + pid;
                $.ajax({
                    type: "PUT",
                    url: url,
                    data: JSON.stringify(row),
                    contentType: 'application/json;charset=utf-8',
                    traditional: true,
                    dataType: 'json',
                    success: function (data, status) {
                        if (status == "success") {
                            alert('提交数据成功');
                        }
                    },
                    error: function () {
                        alert('fail');
                    },
                    complete: function () {

                    }
                });
            }

        });

        function operateFormatter(value, row, index) {
            var pid = [row.pid];
            var Url = '<a id="Remove" class="fa fa-times-circle-o" href="http://localhost:8080/deletePerson?deletedPid=' + pid + '"onclick="return deleteConfirm()" title="Remove">';
            return [
                Url,
                '</a>'
            ].join('');
        }

        function operateEvents() {
            window.operateEvents = {
                'click .remove': function (e, value, row, index) {
                    $("#PersonTable").bootstrapTable('remove', {
                        field: 'pid',
                        values: [row.id]
                    });
                }
            };
        }


    })
})
