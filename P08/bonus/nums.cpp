#include <iostream>
#include <vector>


int main(int argc, char* argv[]) 
{
    std::vector<std::string> numbers;
    std::vector<std::string>* words = new std::vector<std::string>;

    for (int i = 1; i < argc; i++)
    {
        std::string argument = argv[i];

        if (!argument.empty() && std::isdigit(argument[0]))
        {
            numbers.push_back(argument);
        }
        else
        {
            words->push_back(argument);
        }
        
    }

    std::cout << "Numbers:\n";
    for (const std::string& num : numbers) {
        std::cout << num << '\n';
    }

    std::cout << "Words:\n";
    for (const std::string& word : *words) {
        std::cout << word << '\n';
    }

    delete words;


}