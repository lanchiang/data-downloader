#!/bin/bash

cd data/

input="../datafile-links-text.txt"

while IFS=$'\t' read -ra line
do
	url="${line[0]}"
	url_last=${url##*/}
	if [[ $url_last == *txt ]] ;
	then
		echo $url_last
		wget -O "$url_last" "${line[0]}"
	else
		name="${line[1]}"
		if [[ $name == *txt ]] ;
		then
			echo $name
			wget -O "$name" "$url"
		fi
	fi
done < "$input"
