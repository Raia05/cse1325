#ifndef __CLOCK_H
#define __CLOCK_H


#include <iostream>
#include <iomanip>

class Clock
{
    protected:
        int _hours, _minutes, _seconds;
        
    public:
        Clock(int hours, int minutes, int seconds);
        virtual ~Clock();
        virtual void tic();
        void print();
};

#endif