

const Home = () => {


    return (
        <div className="flex flex-col border-4 gap-4 w-screen h-screen p-2">
            <div className="flex justify-center border-2 border-gray-400">
                Navbar
            </div>

            <div className="flex justify-center border-2 border-blue-800">

                <div className="border gap-2 border-green-600 p-2 m-1">
                    Income-List
                </div>

                <div className="border gap-2 border-red-600 p-2 m-1">
                    Expense-List
                </div>

                <div className="flex flex-col">
                    <div className="border gap-2 border-cyan-600 p-2 m-1">
                        Savings-List
                    </div>
                    <div className="border gap-2 border-cyan-600 p-2 m-1">
                        Savings-Goal
                    </div>
                </div>

            </div>

            <div className="flex justify-center border-2 gap-2 border-gray-500">
                <div className="border border-gray-400 p-2 m-1">Graph Donut</div>

                <div className="border border-gray-400 p-2 m-1">Graph Year</div>
            </div>
        </div>
    )
}

export default Home