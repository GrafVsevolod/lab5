package commands;

import managers.CollectionManager;
/**
 * вывести среднее значение поля annualTurnover для всех элементов коллекции
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class AverageTurnCommand implements Command{
    @Override
    public void execute(String[] args){
        System.out.println("Average value of annual turnover is: " + CollectionManager.getAverageTurn());
    }

    @Override
    public String getName(){
        return "Average of annual Turnover";
    }

    @Override
    public String getDescription(){
        return "Get the average value of Annual Turnover field";
    }
}
