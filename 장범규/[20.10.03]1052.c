#include <stdio.h>

int main() {
    int n,k,buy;

    scanf("%d %d", &n, &k);

    if (n <= k) {
        printf("%d", 0);
        return 0;
    }

    for (buy = 0;; buy++) {
        int cnt = 0;
        int tmp = n;
        while (tmp != 0) {
            if (tmp%2 == 1) {
                cnt++;
            }
            tmp /= 2;
        }
        if (cnt <= k) {
            break;
        }
        n++;
    }
    printf("%d", buy);
    return 0;
}