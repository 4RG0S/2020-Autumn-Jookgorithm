import sys
input=sys.stdin.readline

N = int(input())
input_list = list( map(int , input().split()))
l = 1
m = 1
for i in range( 1, N ):
    if( input_list[ i - 1 ] <= input_list[i] ):
        l += 1
    else:
        l = 1
    if( l > m ):
        m = l
l = 1
for i in range( 1, N ):
    if( input_list[ i - 1 ] >= input_list[i] ):
        l += 1
    else:
        l = 1
    if( l > m ):
        m = l
print( m )