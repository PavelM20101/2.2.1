package hiber.service;

import hiber.dao.CarDAO;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDAO carDAO;
    @Transactional
    @Override
    public void add(Car car){
        carDAO.add(car);
    }
    @Transactional
    @Override
    public List<Car> listCars(){
        return carDAO.listCars();
    }
}
