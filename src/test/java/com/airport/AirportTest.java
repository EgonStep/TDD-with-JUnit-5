package com.airport;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Given there is a economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @DisplayName("When we have a usual passenger")
        @Nested
        class UsualPassenger {
            @DisplayName("Then you can add and remove him from an economy flight")
            @Test
            public void testEconomyUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(mike);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengers()).get(0)
                                .getName().equals("Mike"))
                );
            }
        }

        @DisplayName("When we have a vip passenger")
        @Nested
        class VipPassenger {
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            @Test
            public void testEconomyVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(john)),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(john);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengers().size()),
                        () -> assertTrue(economyFlight.getPassengers().contains(john)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengers()).get(0)
                                .getName().equals("John"))
                );
            }
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @DisplayName("When we have a usual passenger")
        @Nested
        class UsualPassenger {
            @DisplayName("Then you cannot add or remove him from a business flight")
            @Test
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        () -> assertEquals("2", businessFlight.getId()),
                        () -> assertEquals(false, businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengers().size())
                );
            }
        }

        @DisplayName("When we have a vip passenger")
        @Nested
        class VipPassenger {
            @DisplayName("Then you can add him but cannot remove him from a business flight")
            @Test
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and a business flight",
                        () -> assertEquals("2", businessFlight.getId()),
                        () -> assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertTrue(businessFlight.getPassengers().contains(john)),
                        () -> assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengers().size() )
                );
            }

            @DisplayName("Then you cannot add him to an business flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(john);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, businessFlight.getPassengers().size()),
                        () -> assertTrue(businessFlight.getPassengers().contains(john)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengers()).get(0)
                                .getName().equals("John"))
                );
            }
        }
    }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @DisplayName("When we have a usual passenger")
        @Nested
        class UsualPassenger {
            @DisplayName("Then you cannot add or remove him from a premium flight")
            @Test
            public void testPremiumFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        () -> assertEquals("3", premiumFlight.getId()),
                        () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size())
                );
            }
        }

        @DisplayName("When we have a vip passenger")
        @Nested
        class VipPassenger {
            @DisplayName("Then you can add or remove him from a premium flight")
            @Test
            public void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a vip passenger and a premium flight",
                        () -> assertEquals("3", premiumFlight.getId()),
                        () -> assertEquals(true, premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengers().size()),
                        () -> assertTrue(premiumFlight.getPassengers().contains(john)),
                        () -> assertEquals(true, premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengers().size())
                );
            }

            @DisplayName("Then you cannot add him to an premium flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    premiumFlight.addPassenger(john);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, premiumFlight.getPassengers().size()),
                        () -> assertTrue(premiumFlight.getPassengers().contains(john)),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengers()).get(0)
                                .getName().equals("John"))
                );
            }
        }
    }
}
