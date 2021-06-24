$('#btnCreateNewAccount').click(async function () {


    var fileObject = $("#txtcustomerImage")[0].files[0];//access file object from input field
    var fileName = fileObject.name; //get file name
    var form = new FormData(); //setup form data object to send file data
    form.append("custImage", fileObject, fileName); //append data

    const data = JSON.stringify({
        fileObject: await fileObject.text(), fileName
    })
    console.log("Test" + data)

    console.log('clicked..');
    let customerNIC = $('txtcustomerNIC').val();
    let customerName = $('txtcustomerName').val();
    let customerAddress = $('txtcustomerAddress').val();

    console.log(form)

    $.ajax({
        method: "post",
        url: "http://localhost:8080/Sprinf_Final-Back-end/customer",
        contentType: "application/json",
        data: JSON.stringify({
            customerNIC: customerNIC,
            customerName: customerName,
            customerAddress: customerAddress,
            data: data

        }),
        success: function (res) {
            if (res.massage == 'Success') {
                alert('Your Account is Successfully Created!When You Log to Server Use Your User Name & Password..!');
                console.log(res);
            } else {
                console.log('error');
            }
        }
    });

});


$('#txtHomeLogin').click(function () {
    window.location.href = "Register.html";
})

$('#txtHomeRegister').click(function () {
    window.location.href = "Login.html";

})
