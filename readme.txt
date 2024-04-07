compilar:
mvn clean package

atualizar:
mvn versions:display-dependency-updates
mvn versions:use-latest-versions
mvn clean install -U

notacoes:
@Export
@Import
@Replace
@Partial
@WasmTextCode