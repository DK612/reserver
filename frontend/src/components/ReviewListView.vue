<template>

    <v-data-table
        :headers="headers"
        :items="reviewList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReviewListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userName", value: "userName" },
                { text: "lodgingId", value: "lodgingId" },
                { text: "rating", value: "rating" },
                { text: "detail", value: "detail" },
            ],
            reviewList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reviewLists'))

            temp.data._embedded.reviewLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reviewList = temp.data._embedded.reviewLists;
        },
        methods: {
        }
    }
</script>

