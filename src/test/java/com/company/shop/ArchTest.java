package com.company.shop;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.company.shop");

        noClasses()
            .that()
                .resideInAnyPackage("com.company.shop.service..")
            .or()
                .resideInAnyPackage("com.company.shop.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.company.shop.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
