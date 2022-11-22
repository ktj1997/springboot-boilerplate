package spring.layer.template;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.DisplayName;

class ModuleDependencyTests {

    @IntegrationTest
    @DisplayName("Domain Layer 의존성 확인")
    void checkDomainLayerDependencies() {
        final String ROOT_PACKAGE = "spring.layer.template";
        JavaClasses root = new ClassFileImporter().importPackages(ROOT_PACKAGE);

        /** Service Dependency Check */
        ArchRule serviceDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..domain.service..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain..", "..adapter.in.web..", "..adapter.in.message");

        /** Processor Dependency Check */
        ArchRule processorDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..domain.processor..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain..");

        /** Internal Dto Dependency Check */
        ArchRule internalDtoDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..domain.dto..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain..");

        /** Domain Model Dependency Check */
        ArchRule domainModelDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..domain.model..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain.model..", "..adapter.out.persistence.rdb..");

        serviceDependencyRule.allowEmptyShould(true).check(root);
        processorDependencyRule.allowEmptyShould(true).check(root);
        internalDtoDependencyRule.allowEmptyShould(true).check(root);
        domainModelDependencyRule.allowEmptyShould(true).check(root);
    }

    @IntegrationTest
    @DisplayName("Adapter Layer 의존성 확인")
    void checkAdapterLayerDependencies() {

        final String ROOT_PACKAGE = "spring.layer.template";

        JavaClasses root = new ClassFileImporter().importPackages(ROOT_PACKAGE);

        /** Web Input Adapter Check */
        ArchRule webInputAdapterDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..adapter.in.web..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..adapter.in.web..");

        /** MQ Input Adapter Check */
        ArchRule messageInputAdapterDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..adapter.in.message..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..adapter.in.message..");

        /** Persistence Output adapter Check */
        ArchRule persistenceOutputAdapterDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..adapter.out.persistence..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..adapter.out.persistence..");

        /** Gateway Output Adapter Check */
        ArchRule gatewayOutputAdapterDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..adapter.out.gateway..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..adapter.out.gateway..");

        /** Message Output Adapter Check */
        ArchRule messageOutputAdapterDependencyRule =
                ArchRuleDefinition.classes()
                        .that()
                        .resideInAnyPackage("..adapter.out.message..")
                        .should()
                        .onlyBeAccessed()
                        .byAnyPackage("..domain.port.out.message..", "..adapter.out.message..");

        webInputAdapterDependencyRule.allowEmptyShould(true).check(root);
        messageInputAdapterDependencyRule.allowEmptyShould(true).check(root);

        persistenceOutputAdapterDependencyRule.allowEmptyShould(true).check(root);
        gatewayOutputAdapterDependencyRule.allowEmptyShould(true).check(root);
        messageOutputAdapterDependencyRule.allowEmptyShould(true).check(root);
    }
}
