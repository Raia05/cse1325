#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main(int argc, char* argv[])
{
    std::map<std::string, Purse> vault;
    int account_count;

    std::cout << "Enter the number of accounts to create: ";
    std::cin >> account_count;
    std::cin.ignore();

    for (int i = 0; i < account_count; i++) 
    {
        std::string name;
        int pounds, shillings, pence;
        
        std::cout << "Name account " << i << ": ";
        std::getline(std::cin, name);
        
        std::cout << "Enter initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();

        try 
        {
            vault[name] = Purse(pounds, shillings, pence);
            std::cout << "Account " << name << " created with " << vault[name] << "\n";
        } 
        catch (std::invalid_argument& e) 
        {
            std::cerr << "Error: " << e.what() << " Please enter non-negative values.\n";
            i--;
            continue;
        }
    }

    Purse total;

    std::cout << "\nAccount List:\n";
    for (const auto& [name, purse] : vault) 
    {
        std::cout << name << ": " << purse << "\n";
        total += purse;
    }

    std::cout << "\nTotal amount of money in the bank: " << total << "\n";
    return 0;
}