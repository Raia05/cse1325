#include "clock.h"


Clock::Clock(int hours, int minutes, int seconds) : _hours(hours), _minutes(minutes), _seconds(seconds) 
{
    if (hours < 0 || hours > 23) 
    {
        throw std::out_of_range("Invalid time value at hours: " + hours);
    }

    if(minutes < 0 || minutes > 59)
    {
        throw std::out_of_range("Invalid time value at minutes: " + minutes);
    }

    if(seconds < 0 || seconds > 59)
    {
        throw std::out_of_range("Invalid time value seconds: " + seconds);
    }
}

Clock::~Clock() {};

void Clock::print() 
{
    std::cout << std::setfill('0') << std::setw(2) << _hours << ":" << std::setfill('0') << std::setw(2) << _minutes << ":" << std::setfill('0') << std::setw(2) << _seconds << std::endl;
}

void Clock::tic() 
{
    _seconds++;
    if (_seconds == 60) 
    {
        _seconds = 0;
        _minutes++;
        if (_minutes == 60) 
        {
            _minutes = 0;
            _hours = (_hours + 1) % 24;
        }
    }
}