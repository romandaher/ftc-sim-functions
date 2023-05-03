public void R(int v){
    driveRight.setPower(v);
}

public void L(int v){
    driveLeft.setPower(v);
}
public void go(int ms) {
    // ms - amount of time to go
    L(-1);
    R(1);
    sleep(ms);
    stop();
    sleep(200);
}
public void rotate(int deg) {
    double ms = deg *(2.8 + (1/3));
    ms = ms / 2;
    L(1);
    R(1);
    sleep(ms);
    L(0);
    R(0);
    sleep(100);
}

public void stop(){
    R(0);
    L(0);
}
public void upd(){
    telemetry.addData("Red", color1.red());
    telemetry.addData("Blue", color1.blue());
    telemetry.addData("Green", color1.green());
    telemetry.update();
}


public void grab(int pos) {
    grabber.setPosition(pos);
    sleep(500);
}




public void back(int ms) {
    L(1);
    R(-1);
    sleep(ms);
    stop();
    sleep(200);
}





public void go_wall() {
    while (distance1.getDistance(DistanceUnit.CM) > 80) {
      go(1);
      upd();
  }
}
