package com.example.insentivetest.service.patient;

import com.example.insentivetest.modele.patient.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface PatientServiceLocal extends CrudRepository<Patient,Integer> {

    @Override
    public <S extends Patient> S save(S entity);

    @Override
    public <S extends Patient> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    public Optional<Patient> findById(Integer integer);

    @Override
    public boolean existsById(Integer integer) ;

    @Override
    public Iterable<Patient> findAll();

    @Override
    public Iterable<Patient> findAllById(Iterable<Integer> integers);

    @Override
    public long count();

    @Override
    public void deleteById(Integer integer);

    @Override
    public void delete(Patient entity);

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    public void deleteAll(Iterable<? extends Patient> entities);

    @Override
    public void deleteAll();
}
