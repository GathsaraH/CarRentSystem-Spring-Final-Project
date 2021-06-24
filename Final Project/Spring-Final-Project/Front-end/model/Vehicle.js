function VehicleDTO(bookingID, vehicleRegID, custName, lossDamage, lossDamageImage, rentData, returnData, driverNICNumber) {
    var __bookingID = bookingID;
    var __vehicleRegID = vehicleRegID;
    var __custName = custName;
    var __lossDamage = lossDamage;
    var __lossDamageImage = lossDamageImage;
    var __rentData = rentData;
    var __returnData = returnData;
    var __driverNICNumber = driverNICNumber;


    this.getbookingID = function () {
        return __bookingID;
    }
    this.getvehicleRegID = function () {
        return __vehicleRegID;
    }

    this.getcustName = function () {
        return __custName;
    }

    this.getlossDamage = function () {
        return __lossDamage;
    }

    this.getlossDamageImage = function () {
        return __lossDamageImage;
    }
    this.getrentData = function () {
        return __rentData;
    }

    this.getreturnData = function () {
        return __returnData;
    }

    this.getdriverNICNumber = function () {
        return __driverNICNumber;
    }


    this.setbookingID = function (ookingID) {
        __bookingID = ookingID;
    }
    this.setvehicleRegID = function (vehicleRegID) {
        __vehicleRegID = vehicleRegID;
    }

    this.setcustName = function (custName) {
        __custName = custName;
    }

    this.setlossDamage = function (lossDamage) {
        __lossDamage = lossDamage;
    }

    this.setlossDamageImage = function (lossDamageImage) {
        __lossDamageImage = lossDamageImage;
    }
    this.setrentData = function (rentData) {
        __rentData = rentData;
    }

    this.setreturnData = function (returnData) {
        __returnData = returnData;
    }
    this.setdriverNICNumber = function (driverNICNumber) {
        __driverNICNumber = driverNICNumber;
    }


}



