#!/bin/bash

amount=1000

for i in `seq 0 200`;
do
	start=$(($i*$amount))
	echo "row: $amount, start: $start"
	file_name="data-gov-${start}.json"
	echo $file_name
	curl "https://catalog.data.gov/api/3/action/package_search?rows=1000&start=${start}" >> "dataset-metadata/${file_name}"
done
