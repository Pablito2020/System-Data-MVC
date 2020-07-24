package components.implementations;

import components.Component;

import java.util.StringTokenizer;

public class TimerComp implements Component {

    private Time time;
    private double passed = 0;
    private int minutes = 0;
    private int hours = 0;

    public TimerComp() {
        this.time = new Time();
    }

    @Override
    public String getInformation() {
        return "Seconds passed: " + passed;
    }

    @Override
    public void update() {
       String information = time.getInformation();
       StringTokenizer tokens = new StringTokenizer(information, ": ");
       tokens.nextToken();
       tokens.nextToken();
       int currentHour = Integer.parseInt(tokens.nextToken());
       int currentMinutes = Integer.parseInt(tokens.nextToken());
       double currentSeconds = Double.parseDouble(tokens.nextToken());
       this.passed += (currentHour - hours) * 3600;
       this.passed += (currentMinutes - minutes) * 60;
       this.passed += currentSeconds;
    }

}
