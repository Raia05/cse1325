#include <iostream>
#include "clock.h"
#include <string>


int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try 
    {
        int hours = std::atoi(argv[1]);
        int minutes = std::atoi(argv[2]);
        int seconds = std::atoi(argv[3]);
        Clock clock(hours, minutes, seconds);

        std::cout << "enter 'q' to quit" << std::endl;
        
        while (true) 
        {
            clock.print();
            std::string input;
            std::getline(std::cin, input);
            if (input == "q" && !input.empty()) break;
            clock.tic();
        }
    } 
    catch (const std::out_of_range& e) 
    {
        std::cerr << e.what() << std::endl;
        return -2;
    }

    return 0;
}
