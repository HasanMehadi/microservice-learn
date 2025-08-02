#!/usr/bin/env bash
# Use this script to test if a given TCP host/port are available

set -e

HOST=$1
shift
PORT=$1
shift

cmd="$@"

echo "Waiting for $HOST:$PORT..."

while ! nc -z $HOST $PORT; do
  sleep 1
done

echo "$HOST:$PORT is available, running command: $cmd"
exec $cmd
