function deleteConfirm() {
    var c = confirm("Are you sure to delete the person?");
    if (c == true) {
        return true;
    } else {
        return false;
    }
}

$(function(){
 $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
})


$(function () {
    $(function () {
        $('#AdminTable').bootstrapTable({
            url: "http://localhost:8080/admin/",
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
            idField: "aid",
            columns: [{
                checkbox: true
            }, {
                field: "aid",
                title: "ID",
                align: 'center'
            }, {
                field: "aname",
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
                field: 'authority.role',
                title: 'Role',
                align: 'center',
                editable: {
                    type: 'select',
                    title: 'Role',
                    source:[{value:"ROLE_ADMIN",text:"Admin"},{value:"ROLE_USER",text:"User"}]
                }
            }, {
                title: "Operations",
                events: operateEvents,
                formatter: operateFormatter
            }],
            onEditableSave: function (field, row, oldValue, $el) {
                var data= JSON.stringify(row);
                var begin = data.indexOf(field);
                var role = data.substr(begin+field.length+3);
                var end = role.indexOf('"');
                role=role.substr(0,end);
                row.authority.role=role;
                var url = "http://localhost:8080/admin/" + row.aid;
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
            var aid = [row.aid];
            var Url = '<a id="Remove" methods="GET" class="fa fa-times-circle-o" href="http://localhost:8080/deleteAdmin?aid=' + aid + '" onclick="return deleteConfirm()" title="Remove">';
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
