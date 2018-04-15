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

