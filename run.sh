#!/bin/sh
set -eu
cd "$(dirname "$0")"
./mvnw -q -DskipTests package
exec "${JAVA_HOME:+$JAVA_HOME/bin/}java" -cp target/classes training.quote.QuoteApp "$@"
