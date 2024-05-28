package data.comporators;

import data.HumanBeing;

import java.util.Comparator;

public class HumanBeingComparator implements Comparator<HumanBeing> {
    /**
     * Метод для сравнения
     *
     * @param h1 the first object to be compared.
     * @param h2 the second object to be compared.
     * @return the value 0 if this object is equal to the argument
     */
    @Override
    public int compare(HumanBeing h1, HumanBeing h2){
        if(h1.getCoordinates().getVektor(h1.getCoordinates().getX(), h1.getCoordinates().getY()) == h2.getCoordinates().getVektor(h2.getCoordinates().getX(), h2.getCoordinates().getY())){
            return 0;
        }else if(h1.getCoordinates().getVektor(h1.getCoordinates().getX(), h1.getCoordinates().getY()) > h2.getCoordinates().getVektor(h2.getCoordinates().getX(), h2.getCoordinates().getY())){
            return 1;
        }else{
            return -1;
        }
    }
}
