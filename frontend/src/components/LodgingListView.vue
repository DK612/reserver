<template>

    <v-data-table
        :headers="headers"
        :items="lodgingList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'LodgingListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "name", value: "name" },
                { text: "address", value: "address" },
                { text: "pricePerDay", value: "pricePerDay" },
                { text: "rating", value: "rating" },
            ],
            lodgingList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/lodgingLists'))

            temp.data._embedded.lodgingLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.lodgingList = temp.data._embedded.lodgingLists;
        },
        methods: {
        }
    }
</script>

