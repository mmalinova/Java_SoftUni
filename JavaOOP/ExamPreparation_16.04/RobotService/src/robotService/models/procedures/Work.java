package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure{
    public Work() {
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        robot.setEnergy(robot.getEnergy() - 6);
        robot.setHappiness(robot.getHappiness() + 12);
        super.doService(robot, procedureTime);
    }
}
