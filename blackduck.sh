curl --silent -O https://detect.synopsys.com/detect.sh
chmod +x detect.sh
./detect.sh \
--detect.timeout=6000 \
--blackduck.trust.cert=true \
--detect.blackduck.signature.scanner.memory=4096 \
--detect.blackduck.signature.scanner.paths=~/work/flutter-plugin-for-sap-emarsys-customer-engagement \
--detect.code.location.name="https://github.com/emartech/flutter-plugin-for-sap-emarsys-customer-engagement" \
--detect.project.name="Github:emartech\ /\ flutter-plugin-for-sap-emarsys-customer-engagement" \
--detect.project.version.name=master \
--detect.source.path=~/work/flutter-plugin-for-sap-emarsys-customer-engagement \
--detect.npm.include.dev.dependencies=false \
--detect.sbt.report.search.depth=4 \
