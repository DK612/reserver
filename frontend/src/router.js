
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReviewReviewManager from "./components/listers/ReviewReviewCards"
import ReviewReviewDetail from "./components/listers/ReviewReviewDetail"

import LodgingLodgingManager from "./components/listers/LodgingLodgingCards"
import LodgingLodgingDetail from "./components/listers/LodgingLodgingDetail"

import ReservationReservationManager from "./components/listers/ReservationReservationCards"
import ReservationReservationDetail from "./components/listers/ReservationReservationDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"

import EmailAlertManager from "./components/listers/EmailAlertCards"
import EmailAlertDetail from "./components/listers/EmailAlertDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reviews/reviews',
                name: 'ReviewReviewManager',
                component: ReviewReviewManager
            },
            {
                path: '/reviews/reviews/:id',
                name: 'ReviewReviewDetail',
                component: ReviewReviewDetail
            },

            {
                path: '/lodgings/lodgings',
                name: 'LodgingLodgingManager',
                component: LodgingLodgingManager
            },
            {
                path: '/lodgings/lodgings/:id',
                name: 'LodgingLodgingDetail',
                component: LodgingLodgingDetail
            },

            {
                path: '/reservations/reservations',
                name: 'ReservationReservationManager',
                component: ReservationReservationManager
            },
            {
                path: '/reservations/reservations/:id',
                name: 'ReservationReservationDetail',
                component: ReservationReservationDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },

            {
                path: '/emails/alerts',
                name: 'EmailAlertManager',
                component: EmailAlertManager
            },
            {
                path: '/emails/alerts/:id',
                name: 'EmailAlertDetail',
                component: EmailAlertDetail
            },



    ]
})
