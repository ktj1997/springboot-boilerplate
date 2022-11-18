package spring.layer.template.integration;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.DisplayName;

class ModuleDependencyTests {

    @IntegrationTest
    @DisplayName("모듈간 의존성 확인")
    void architectureCheck() {

        final String ROOT_PACKAGE = "spring.layer.template";

        JavaClasses root =
                new ClassFileImporter()
                        .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                        .importPackages(ROOT_PACKAGE);

        ArchRule presentationDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..presentation..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..presentation..");

        ArchRule applicationDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..application..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..application..", "..presentation..");

        ArchRule domainDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..domain..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain..", "..application..", "..infrastructure..");

        ArchRule infrastructureDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..infrastructure..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..infrastructure..");

        presentationDependencyRule.check(root);
        applicationDependencyRule.check(root);
        domainDependencyRule.check(root);
        infrastructureDependencyRule.check(root);
    }
}
