package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure{
    public Charge() {
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
        super.doService(robot, procedureTime);
    }
}
