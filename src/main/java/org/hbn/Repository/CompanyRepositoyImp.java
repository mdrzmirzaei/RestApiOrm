package org.hbn.Repository;

import jakarta.persistence.EntityManager;
import org.hbn.Entity.Company;
import java.util.Optional;

public class CompanyRepositoyImp implements CompanyRepository {
    private EntityManager entityManager;

    @Override
    public Optional<Company> save(Company company) {
        try {
            entityManager.getTransaction().begin();
            if (company.getId() == null) {
                entityManager.persist(company);
            } else {
                entityManager.merge(company);
            }
            entityManager.getTransaction().commit();
            return Optional.of(company);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Company> getCompanyByID(Long id) {
        Company company = entityManager.find(Company.class, id);
        return company != null ? Optional.of(company) : Optional.empty();
    }

    @Override
    public void deleteCompany(Company company) {
        entityManager.getTransaction().begin();
        if (entityManager.contains(company)) {
            entityManager.remove(company);
        } else {
            entityManager.merge(company);
        }
        entityManager.getTransaction().commit();
    }
}
