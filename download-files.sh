#!/bin/bash

cd data_excel/

input="../datafile-links.txt"

while IFS=$'\t' read -ra line
do
	url="${line[0]}"
	url_last=${url##*/}
	if [[ $url_last == *xls ]] || [[ $url_last == *xlsx ]] ;
	then
		echo $url_last
		wget -O "$url_last" "${line[0]}"
	else
		name="${line[1]}"
		if [[ $name == *xls ]] || [[ $name == *xlsx ]] ;
		then
			echo $name
			wget -O "$name" "$url"
		fi
	fi
done < "$input"
