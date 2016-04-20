#!/usr/bin/env bash
## Hack to workaround scoverage/sbt-scoverage#115
## We let travis append coverage settings for coverage tasks only

ci=${TRAVIS}

scoverage_plugin_dependency="addSbtPlugin(\"org.scoverage\" % \"sbt-scoverage\" % \"1.3.5\")"

coveralls_plugin_dependency="addSbtPlugin(\"org.scoverage\" % \"sbt-coveralls\" % \"1.1.0\")"

coveralls_token_setting="CoverallsKeys.coverallsToken := sys.env.get(\"COVERALLS_TOKEN\")"

coveralls_enabled_setting="coverageEnabled := true"

if [ -n "${CI}" ]; then
echo -e "\n\n${scoverage_plugin_dependency}\n\n${coveralls_plugin_dependency}" >> ${TRAVIS_BUILD_DIR}/project/plugins.sbt
echo -e "\n\n${coveralls_token_setting}\n\n${coveralls_enabled_setting}\n\n" >> ${TRAVIS_BUILD_DIR}/build.sbt
exit 0
else
exit 0
fi
