#!/bin/bash

cd data_excel_uk/

input="../datafile-links-excel-uk.txt"

while IFS=$'\t' read -ra line
do
	url="${line[0]}"
	url_last=${url##*/}
	if [[ $url_last == *xls ]] || [[ $url_last == *xlsx ]] ;
	then
		echo $url_last
		wget -O "$url_last" "${line[0]}"
	fi
done < "$input"
