package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.Medicine;

import java.util.List;

public interface IMedicineDAO extends IBaseDAO<Medicine>{
    List<Medicine> showAllMedicines();
}
