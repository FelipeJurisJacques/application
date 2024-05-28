https://github.com/i-net-software/JWebAssembly-API

compilar:
mvn clean package

atualizar:
mvn versions:display-dependency-updates
mvn clean install -U

nao utilizar o comando a baixo (quebra a versao):
mvn versions:use-latest-versions

notacoes:
@Export
@Import
@Replace
@Partial
@WasmTextCode