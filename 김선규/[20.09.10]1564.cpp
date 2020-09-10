#include <iostream>
#include <string>

int main() {
	int n;
	std::cin >> n;
	
	long long int an = 1;
	for (int i = 1; i <= n; i++) {
		an *= i;
		while (an % 10 == 0) {
			an /= 10;
		}
		an %= 1000000000000;
	}
	std::string s = std::to_string(an);
	s = s.substr(s.length() - 5, s.length());
	std::cout << s << std::endl;
}