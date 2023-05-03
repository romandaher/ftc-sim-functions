    public void R(int v){
      //Sets power of right side motors to 1
        backRightDrive.setPower(v);
        frontRightDrive.setPower(v);
    }
    
    public void L(int v){
      //Sets power of left side motors to 1
        backLeftDrive.setPower(v);
        frontLeftDrive.setPower(v);
    }

    public void stop(){
      //Sets power of all motors to 0 (stopping the robot)
        R(0);
        L(0);
    }
