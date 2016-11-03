count=$1
i=0
while [ $i != $count ]; do
  echo "Running iteration $i"
./httpcore-ab.sh -n $2 -c $3  -p $4  -t 360000   -H "routeId:r1","valid:true","routing:xadmin;server1;community#1.0##" -T "text/xml" $5 

  i=`expr $i + 1`
done




