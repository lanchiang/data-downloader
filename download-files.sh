#!/bin/bash

cd data/

input="../datafile-links.txt"

while IFS=$'\t' read -ra line
do
	echo "${line[0]}"
	echo "${line[1]}"
	wget -O "${line[1]}" "${line[0]}"
done < "$input"
