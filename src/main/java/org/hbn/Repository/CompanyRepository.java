package org.hbn.Repository;

import org.hbn.Entity.Company;

import java.util.Optional;

public interface CompanyRepository {

    Optional<Company> save(Company company);

    Optional<Company> getCompanyByID(Long id);

    void deleteCompany(Company company);
}
